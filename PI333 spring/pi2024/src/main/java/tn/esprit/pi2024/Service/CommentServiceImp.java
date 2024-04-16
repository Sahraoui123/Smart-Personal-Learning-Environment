package tn.esprit.pi2024.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pi2024.Entity.Comment;
import tn.esprit.pi2024.Repository.CommentRepo;

import java.util.List;

@Service
public class CommentServiceImp implements ICommentService{
    @Autowired
    CommentRepo commentRepo;

    public List<Comment> retrieveAllComments(){
        return commentRepo.findAll();
    }
    public Comment retrieveComment(Long commentId) {
        return commentRepo.findById(commentId).get();
    }
    public Comment addComment(Comment c) {
        return commentRepo.save(c);
    }
    public void removeComment(Long commentId) {
        commentRepo.deleteById(commentId);
    }
    public Comment modifyComment(Comment Comment) {
        return commentRepo.save(Comment);
    }

}
