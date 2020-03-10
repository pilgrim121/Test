package com.example.demo.service;

import com.example.demo.dao.McommentRepository;
import com.example.demo.po.Dcomment;
import com.example.demo.po.Mcomment;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class McommentServiceImpl implements McommentService {

    @Autowired
    private McommentRepository mcommentRepository;

    @Override
    public List<Mcomment> listMcommentByMusicTag(Integer mdataTag) {
        Sort sort= Sort.by(Sort.Direction.DESC,"createTime");
        List<Mcomment> mcomments=mcommentRepository.findByMdataTagAndParentCommentNull(mdataTag,sort);
        return eachMcomment(mcomments);
    }

    @Transactional
    @Override
    public Mcomment saveMcomment(Mcomment mcomment) {
        Long parentCommentId=mcomment.getParentComment().getId();
        //此时是回复
        if(parentCommentId!=-1){
            mcomment.setParentComment(mcommentRepository.getOne(parentCommentId));
        }else{
            mcomment.setParentComment(null);
        }
        mcomment.setCreateTime(new Date());
        return mcommentRepository.save(mcomment);
    }


    /**
     * 循环每个顶级的评论节点
     * @param mcomments
     * @return
     */
    private List<Mcomment> eachMcomment(List<Mcomment> mcomments) {
        List<Mcomment> mcommentsView = new ArrayList<>();
        for (Mcomment mcomment : mcomments) {
            Mcomment c = new Mcomment();
            BeanUtils.copyProperties(mcomment,c);
            mcommentsView.add(c);
        }
        //合并评论的各层子代到第一级子代集合中
        combineChildren(mcommentsView);
        return mcommentsView;
    }

    /**
     *
     * @param mcomments root根节点，blog不为空的对象集合
     * @return
     */
    private void combineChildren(List<Mcomment> mcomments) {

        for (Mcomment mcomment : mcomments) {
            List<Mcomment> replys1 = mcomment.getReplyComments();
            for(Mcomment reply1 : replys1) {
                //循环迭代，找出子代，存放在tempReplys中
                recursively(reply1);
            }
            //修改顶级节点的reply集合为迭代处理后的集合
            mcomment.setReplyComments(tempReplys);
            //清除临时存放区
            tempReplys = new ArrayList<>();
        }
    }

    //存放迭代找出的所有子代的集合
    private List<Mcomment> tempReplys = new ArrayList<>();
    /**
     * 递归迭代，剥洋葱
     * @param mcomment 被迭代的对象
     * @return
     */
    private void recursively(Mcomment mcomment) {
        tempReplys.add(mcomment);//顶节点添加到临时存放集合
        if (mcomment.getReplyComments().size()>0) {
            List<Mcomment> replys = mcomment.getReplyComments();
            for (Mcomment reply : replys) {
                tempReplys.add(reply);
                if (reply.getReplyComments().size()>0) {
                    recursively(reply);
                }
            }
        }
    }



}
