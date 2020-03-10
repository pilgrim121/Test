package com.example.demo;

import com.example.demo.dao.ResourceRepository;
import com.example.demo.po.Resource;
import org.apache.commons.io.FileUtils;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import org.junit.jupiter.api.Test;

/**
 * @author yxx
 * @create 2020-01-11 12:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceTest {

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private ElasticsearchTemplate template;

    /*创建索引*/
    @Test
    ////创建索引，并配置映射关系
    public void createIndex() throws Exception{
        template.createIndex(Resource.class);
        template.putMapping(Resource.class);
    }


    /*添加文档*/
    @Test
    public void addDocument() throws Exception {

        /*批量添加数据*/
        List<Resource> list=extractFile();
        resourceRepository.saveAll(list);


         /*
         一条一条添加数据的方法
        //FileModel fileModel=new FileModel();
        for(int i=0;i<list.size();i++){

            fileModel.setId(list.get(i).getId());
            fileModel.setTitle(list.get(i).getTitle());
            fileModel.setContent(list.get(i).getContent());

            fileRepository.save(fileModel);
        }
        */

    }



    /*根据标题或者内容进行查询*/
    /*注意：此时每页默认显示10条数据*/
    @Test
    public void testFindByTitleOrContent() throws Exception{
        List<Resource> list = resourceRepository.findByTitleOrContent("戏曲", "歌曲");
        list.stream().forEach(a-> System.out.println(a));
    }

    /*设置分页，每页显示5条数据*/
    @Test
    public void testFindByTitleOrContentPage() throws Exception{
        //分页默认从第0页开始
        Pageable pageable= PageRequest.of(0,5);
        resourceRepository.findByTitleOrContent("荷花舞","荷花舞",pageable)
                .forEach(a-> System.out.println(a));
    }


    /*
     * 功能:使用Tika提取文件内容 参数：文件对象 返回值: String格式的文档内容
     */

    public static String parserFile(File file){
        try {
            String fileContent = "";// 接收文档内容
            BodyContentHandler bodyContentHandler = new BodyContentHandler();
            Metadata metadata = new Metadata();
//            Metadata metadata = new Metadata();
            ParseContext context = new ParseContext();

            FileInputStream inputStream = new FileInputStream(file);


            Parser parser = new AutoDetectParser();// 自动解析器接口
            parser.parse(inputStream, bodyContentHandler, metadata, context);
            fileContent=bodyContentHandler.toString();

            return fileContent;

        } catch (IOException | TikaException | SAXException e) {
            e.printStackTrace();
        }

        return "提取文件内容失败";
    }


    /*
     * 功能:列出files目录下的所有文件 参数:无 返回值:Resource类型的列表
     */
    public static List<Resource> extractFile() throws Exception {

        ArrayList<Resource> list = new ArrayList<Resource>();
        File fileDir = new File("files");
        if (!fileDir.exists()) {
            System.out.println("文件夹路径错误!");
        }
        File[] allFiles = fileDir.listFiles();
        int count=1;
        for (File f : allFiles) {

            //1.处理tag
            int tag=0;
            String regex="_(.*?)_";
            Pattern p=Pattern.compile(regex);
            Matcher m=p.matcher(f.getName());
            String t="";
            while(m.find()){
                t=m.group(1);
                //System.out.println(t);
                //System.out.println(t.getClass().getName());
            }
            try {
                 tag = Integer.parseInt(t);
                //System.out.println(tag);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }


            //2.处理title
            String title=f.getName().replaceAll("[a-zA-z0-9_.]","");

            //3.处理type
            String type="其他";
                //substring截取html的第一个字符（从0开始，不包含1）,判断资源类型
            switch(f.getName().substring(0,1)){
                case "1":
                    type="戏曲";
                    break;
                case "2":
                    type="舞蹈";
                    break;
                case "3":
                    type="音乐";
                    break;
                case "4":
                    type="节日";
                    break;
                case "5":
                    type="非遗文化";
                    break;
                default:
                    type="其他";
                    break;
            }

            //4.处理content

            //5.处理description
            String discription=parserFile(f).substring(0,120);

            //6.处理content_html
            String s = FileUtils.readFileToString(f);



            Resource sf = new Resource(count,tag,title,type, parserFile(f),discription,s);
            list.add(sf);
            count++;
        }
        return list;
    }


    public static void main(final String[] args) throws Exception {
        List<Resource> list=extractFile();
        //System.out.println(list);

        System.out.println("********************************************");
        for(int i=0;i<list.size();i++){
            System.out.println("id:"+list.get(i).getId());
            System.out.println("title:"+list.get(i).getTitle());
            System.out.println("type:"+list.get(i).getType());
            System.out.println("content:"+list.get(i).getContent());
            System.out.println("description:"+list.get(i).getDescription());
            System.out.println("html:"+list.get(i).getContent_html());
            System.out.println("---------------分割线------------------");
        }


    }


}







