package tn.esprit.pi2024.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pi2024.Entity.Comment;
import tn.esprit.pi2024.Repository.CommentRepo;
import tn.esprit.pi2024.Service.ICommentService;

import java.util.List;
@Tag(name = "Gestion Comment")
@RestController
@AllArgsConstructor
@RequestMapping("/comment")
public class CommentRestController {
    ICommentService commentService;

    // http://localhost:8089/tpfoyer/comment/retrieve-all-comments
    @Operation(description = "Récupérer tous les commentaires de la base de données!")
    @GetMapping("/retrieve-all-comments")
    public List<Comment> getComments() {return commentService.retrieveAllComments();
    }

    // http://localhost:8089/tpfoyer/comment/retrieve-comment/8
    @Operation(description = "Récupérer le comment avec l'ID correspondante de la base de données!")
    @GetMapping("/retrieve-comment/{comment-id}")
    public Comment retrieveComment(@PathVariable("comment-id") Long commentId) {return commentService.retrieveComment(commentId);
    }


    // http://localhost:8089/tpfoyer/comment/add-comment
    @Operation(description = "Ajouter comment à la base de données!")
    @PostMapping("/add-comment")
    public Comment addComment(@RequestBody Comment comment) {return commentService.addComment(comment);
    }
    // http://localhost:8089/tpfoyer/comment/remove-comment/{comment-id}
    @Operation(description = "Enlever le comment avec l'ID correspondante de la base de données!")
    @DeleteMapping("/remove-comment/{comment-id}")
    public void removeComment(@PathVariable("comment-id") Long commentId) {
        commentService.removeComment(commentId);
    }

    // http://localhost:8089/tpfoyer/comment/modify-comment
    @Operation(description = "Modifier le comment!")
    @PutMapping("/modify-comment")
    public Comment modifyComment(@RequestBody Comment comment) {
        return commentService.modifyComment(comment);
    }

}
