package org.example.main;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import org.example.model.Comment;
import org.example.repositories.CommentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)

/*Prototype scope is useful if the member variable is modified internally or within the instance and will cause
* issue during multi-threading. */

public class CommentProcessor {
    private static final Logger logger = LoggerFactory.getLogger(CommentProcessor.class);
    private Comment comment;

    //    @Autowired
    CommentRepository commentRepository;

    public void processComment() {
        comment.setText(comment.getText() + " -- updated");
        logger.info("Processing comment of: " + comment.getAuthor());
    }

    public void validateComment() {
        logger.info("Validating comment of: " + comment.getAuthor());
        comment.setAuthor(comment.getAuthor() + " -- validated");
    }

    @PostConstruct
    void logConstruct() {
        logger.info("Bean CommentProcessor is constructed");
    }


    @PreDestroy
    void logPredestroy(){
        logger.info("Bean CommentProcessor will be destroyed.");
    }

}
