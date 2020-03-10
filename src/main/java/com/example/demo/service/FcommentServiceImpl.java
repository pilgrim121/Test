package com.example.demo.service;


import com.example.demo.dao.FcommentRepository;
import com.example.demo.po.Fcomment;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FcommentServiceImpl implements FcommentService {


    @Autowired
    private FcommentRepository fcommentRepository;

    @Override
    public List<Fcomment> listFcommentByFestivalTag(Integer fdataTag) {
        Sort sort= Sort.by(Sort.Direction.DESC,"createTime");
        List<Fcomment> fcomments=fcommentRepository.findByFdataTagAndParentCommentNull(fdataTag,sort);
        return eachFcomment(fcomments);
    }


    @Transactional
    @Override
    public Fcomment saveFcomment(Fcomment fcomment) {
        Long parentCommentId=fcomment.getParentComment().getId();
        //此时是回复
        if(parentCommentId!=-1){
            fcomment.setParentComment(fcommentRepository.getOne(parentCommentId));
        }else{
            fcomment.setParentComment(null);
        }
        fcomment.setCreateTime(new Date());
        return fcommentRepository.save(fcomment);
    }




    /**
     * 循环每个顶级的评论节点
     * @param fcomments
     * @return
     */
    private List<Fcomment> eachFcomment(List<Fcomment> fcomments) {
        List<Fcomment> fcommentsView = new ArrayList<>();
        for (Fcomment fcomment : fcomments) {
            Fcomment c = new Fcomment();
            BeanUtils.copyProperties(fcomment,c);
            fcommentsView.add(c);
        }
        //合并评论的各层子代到第一级子代集合中
        combineChildren(fcommentsView);
        return fcommentsView;
    }

    /**
     *
     * @param fcomments root根节点，blog不为空的对象集合
     * @return
     */
    private void combineChildren(List<Fcomment> fcomments) {

        for (Fcomment fcomment : fcomments) {
            List<Fcomment> replys1 = fcomment.getReplyComments();
            for(Fcomment reply1 : replys1) {
                //循环迭代，找出子代，存放在tempReplys中
                recursively(reply1);
            }
            //修改顶级节点的reply集合为迭代处理后的集合
            fcomment.setReplyComments(tempReplys);
            //清除临时存放区
            tempReplys = new ArrayList<>();
        }
    }

    //存放迭代找出的所有子代的集合
    private List<Fcomment> tempReplys = new ArrayList<>();
    /**
     * 递归迭代，剥洋葱
     * @param fcomment 被迭代的对象
     * @return
     */
    private void recursively(Fcomment fcomment) {
        tempReplys.add(fcomment);//顶节点添加到临时存放集合
        if (fcomment.getReplyComments().size()>0) {
            List<Fcomment> replys = fcomment.getReplyComments();
            for (Fcomment reply : replys) {
                tempReplys.add(reply);
                if (reply.getReplyComments().size()>0) {
                    recursively(reply);
                }
            }
        }
    }



}
