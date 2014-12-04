/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.MessageFacade;
import entities.Message;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ioanT
 */
@ManagedBean(name = "MessageView")
@RequestScoped
public class MessageView {
    @EJB
    private MessageFacade messageFacade;

    /**
     * Creates a new instance of MessageView
     */
    private Message message;
    
    public MessageView() {
        this.message = new Message();
    }

    public Message getMessage() {
        return message;
    }
    
    public int getNumberOfMessages() {
        return messageFacade.findAll().size();
    }
    
    public String postMessage() {
        this.messageFacade.create(message);
        return "theend";
    }
    
}
