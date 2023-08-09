package org.example;

public class CommentServiceSupplierThread extends Thread{
    CommentService commentService;

    public CommentServiceSupplierThread(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public void run() {
        Comment c = new Comment();
        c.setAuthor(Thread.currentThread().getName());
        c.setMessage("Hello from thread:" + Thread.currentThread().getName());
        commentService.queueComment(c);
    }
}
