package tn.esprit.pi2024.Service;

import tn.esprit.pi2024.Entity.Comment;

import java.util.List;

public interface ICommentService {
    public List<Comment> retrieveAllComments();
    public Comment retrieveComment(Long commentId);
    public Comment addComment(Comment c);
    public void removeComment(Long commentId);
    public Comment modifyComment(Comment comment);

}
