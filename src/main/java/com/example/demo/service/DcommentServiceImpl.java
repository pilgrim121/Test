package com.example.demo.service;

import com.example.demo.dao.DcommentRepository;
import com.example.demo.po.Dcomment;
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
public class DcommentServiceImpl implements DcommentService {


    @Autowired
    private DcommentRepository dcommentRepository;

    @Override
    public List<Dcomment> listDcommentByDanceTag(Integer ddataTag) {
        Sort sort= Sort.by(Sort.Direction.DESC,"createTime");
        List<Dcomment> dcomments=dcommentRepository.findByDdataTagAndParentCommentNull(ddataTag,sort);
        return eachDcomment(dcomments);
    }

    @Transactional
    @Override
    public Dcomment saveDcomment(Dcomment dcomment) {
        Long parentCommentId=dcomment.getParentComment().getId();
        //此时是回复
        if(parentCommentId!=-1){
            dcomment.setParentComment(dcommentRepository.getOne(parentCommentId));
        }else{
            dcomment.setParentComment(null);
        }
        dcomment.setCreateTime(new Date());
        return dcommentRepository.save(dcomment);
    }


    /**
     * 循环每个顶级的评论节点
     * @param dcomments
     * @return
     */
    private List<Dcomment> eachDcomment(List<Dcomment> dcomments) {
        List<Dcomment> dcommentsView = new ArrayList<>();
        for (Dcomment dcomment : dcomments) {
            Dcomment c = new Dcomment();
            BeanUtils.copyProperties(dcomment,c);
            dcommentsView.add(c);
        }
        //合并评论的各层子代到第一级子代集合中
        combineChildren(dcommentsView);
        return dcommentsView;
    }

    /**
     *
     * @param dcomments root根节点，blog不为空的对象集合
     * @return
     */
    private void combineChildren(List<Dcomment> dcomments) {

        for (Dcomment dcomment : dcomments) {
            List<Dcomment> replys1 = dcomment.getReplyComments();
            for(Dcomment reply1 : replys1) {
                //循环迭代，找出子代，存放在tempReplys中
                recursively(reply1);
            }
            //修改顶级节点的reply集合为迭代处理后的集合
            dcomment.setReplyComments(tempReplys);
            //清除临时存放区
            tempReplys = new ArrayList<>();
        }
    }

    //存放迭代找出的所有子代的集合
    private List<Dcomment> tempReplys = new ArrayList<>();
    /**
     * 递归迭代，剥洋葱
     * @param dcomment 被迭代的对象
     * @return
     */
    private void recursively(Dcomment dcomment) {
        tempReplys.add(dcomment);//顶节点添加到临时存放集合
        if (dcomment.getReplyComments().size()>0) {
            List<Dcomment> replys = dcomment.getReplyComments();
            for (Dcomment reply : replys) {
                tempReplys.add(reply);
                if (reply.getReplyComments().size()>0) {
                    recursively(reply);
                }
            }
        }
    }



}
