package com.example.demo.service;

import com.example.demo.dao.OcommentRepository;
import com.example.demo.po.Ocomment;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OcommentServiceImpl implements OcommentService {

    @Autowired
    private OcommentRepository ocommentRepository;

    @Override
    public List<Ocomment> listOcommentByOperaTag(Integer operadataTag) {
        Sort sort= Sort.by(Sort.Direction.DESC,"createTime");
        List<Ocomment> ocomments=ocommentRepository.findByOdataTagAndParentCommentNull(operadataTag,sort);
        return eachOcomment(ocomments);
    }

    @Transactional
    @Override
    public Ocomment saveOcomment(Ocomment ocomment) {

        Long parentCommentId=ocomment.getParentComment().getId();
        //此时是回复
        if(parentCommentId!=-1){
            ocomment.setParentComment(ocommentRepository.getOne(parentCommentId));
        }else{
            ocomment.setParentComment(null);
        }
        ocomment.setCreateTime(new Date());
        return ocommentRepository.save(ocomment);
    }



    /**
     * 循环每个顶级的评论节点
     * @param ocomments
     * @return
     */
    private List<Ocomment> eachOcomment(List<Ocomment> ocomments) {
        List<Ocomment> ocommentsView = new ArrayList<>();
        for (Ocomment ocomment : ocomments) {
            Ocomment c = new Ocomment();
            BeanUtils.copyProperties(ocomment,c);
            ocommentsView.add(c);
        }
        //合并评论的各层子代到第一级子代集合中
        combineChildren(ocommentsView);
        return ocommentsView;
    }

    /**
     *
     * @param ocomments root根节点，blog不为空的对象集合
     * @return
     */
    private void combineChildren(List<Ocomment> ocomments) {

        for (Ocomment ocomment : ocomments) {
            List<Ocomment> replys1 = ocomment.getReplyComments();
            for(Ocomment reply1 : replys1) {
                //循环迭代，找出子代，存放在tempReplys中
                recursively(reply1);
            }
            //修改顶级节点的reply集合为迭代处理后的集合
            ocomment.setReplyComments(tempReplys);
            //清除临时存放区
            tempReplys = new ArrayList<>();
        }
    }

    //存放迭代找出的所有子代的集合
    private List<Ocomment> tempReplys = new ArrayList<>();
    /**
     * 递归迭代，剥洋葱
     * @param ocomment 被迭代的对象
     * @return
     */
    private void recursively(Ocomment ocomment) {
        tempReplys.add(ocomment);//顶节点添加到临时存放集合
        if (ocomment.getReplyComments().size()>0) {
            List<Ocomment> replys = ocomment.getReplyComments();
            for (Ocomment reply : replys) {
                tempReplys.add(reply);
                if (reply.getReplyComments().size()>0) {
                    recursively(reply);
                }
            }
        }
    }



}
