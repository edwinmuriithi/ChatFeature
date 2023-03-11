package com.example.chatfeature;

import static com.example.chatfeature.ModelClass.RECEIVER_IMAGE;
import static com.example.chatfeature.ModelClass.RECEIVER_MESSAGE;
import static com.example.chatfeature.ModelClass.SENDER_IMAGE;
import static com.example.chatfeature.ModelClass.SENDER_MESSAGE;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter{
    List<ModelClass> chatList;
    Context context;

    public MessageAdapter(List<ModelClass> chatList, Context context) {
        this.chatList = chatList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){
            case SENDER_MESSAGE:
                View senderMessage = LayoutInflater.from(context).inflate(R.layout.sender_message_layout,parent,false);
                return new SenderMessageViewHolder(senderMessage);

            case RECEIVER_MESSAGE:
                View receiverMessage = LayoutInflater.from(context).inflate(R.layout.receiver_message_layout,parent,false);
                return new ReceiverMessageViewHolder(receiverMessage);
            case SENDER_IMAGE:
                View senderImage = LayoutInflater.from(context).inflate(R.layout.sender_image_layout,parent,false);
                return new SenderImageViewHolder(senderImage);

            case RECEIVER_IMAGE:
                View receiverImage = LayoutInflater.from(context).inflate(R.layout.receiver_image_layout,parent,false);
                return new ReceiverImageViewHolder(receiverImage);

            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       switch (chatList.get(position).getViewType()){
           case SENDER_MESSAGE:
               String senderMessage = chatList.get(position).getMessage();
               ((SenderMessageViewHolder) holder).setView(senderMessage);
               break;

           case RECEIVER_MESSAGE:
               String receiverMessage = chatList.get(position).getMessage();
               ((ReceiverMessageViewHolder) holder).setView(receiverMessage);
               break;

           case SENDER_IMAGE:
               int senderImage = chatList.get(position).getImage();
               ((SenderImageViewHolder) holder).setImage(senderImage);
               break;

           case RECEIVER_IMAGE:
               int receiverImage = chatList.get(position).getImage();
               ((ReceiverImageViewHolder) holder).setImage(receiverImage);
               break;
       }
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch(chatList.get(position).getViewType()){
            case 1:
                return SENDER_MESSAGE;

            case 2:
                return RECEIVER_MESSAGE;

            case 3:
                return SENDER_IMAGE;

            case 4:
                return RECEIVER_IMAGE;

            default:
                return -1;

        }
    }

    class SenderMessageViewHolder extends RecyclerView.ViewHolder{

        private final TextView senderMessage;

        public SenderMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            senderMessage= itemView.findViewById(R.id.sender);
        }
        private void setView(String text){
            senderMessage.setText(text);
        }
    }
    class ReceiverMessageViewHolder extends RecyclerView.ViewHolder{

        private final TextView receiverMessage;

        public ReceiverMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            receiverMessage= itemView.findViewById(R.id.receiver);
        }
        private void setView(String text){
            receiverMessage.setText(text);
        }
    }
    class SenderImageViewHolder extends RecyclerView.ViewHolder{

        private final ImageView senderImage;

        public SenderImageViewHolder(@NonNull View itemView) {
            super(itemView);
            senderImage= itemView.findViewById(R.id.image_sender);
        }
        private void setImage(int image){
            senderImage.setImageResource(image);
        }
    }
    class ReceiverImageViewHolder extends RecyclerView.ViewHolder{

        private final ImageView receiverImage;

        public ReceiverImageViewHolder(@NonNull View itemView) {
            super(itemView);
            receiverImage= itemView.findViewById(R.id.image_receiver);
        }
        private void setImage(int image){
            receiverImage.setImageResource(image);
        }
    }
}
