package com.example.chatfeature;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.chatfeature.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    RecyclerView recyclerView;
    MessageAdapter messageAdapter;
    ArrayList<ModelClass> chatList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        recyclerView = binding.recyclerChat;
        chatList= new ArrayList<>();

        chatList.add(new ModelClass(ModelClass.SENDER_MESSAGE,"This is a sender message"));
        chatList.add(new ModelClass(ModelClass.RECEIVER_MESSAGE,"This is a receiver message"));
        chatList.add(new ModelClass(ModelClass.SENDER_IMAGE,R.drawable.answer));
        chatList.add(new ModelClass(ModelClass.RECEIVER_IMAGE,R.drawable.coffee));
        chatList.add(new ModelClass(ModelClass.SENDER_MESSAGE,"This is a sender message"));
        chatList.add(new ModelClass(ModelClass.RECEIVER_MESSAGE,"This is a receiver message"));
        chatList.add(new ModelClass(ModelClass.SENDER_IMAGE,R.drawable.answer));
        chatList.add(new ModelClass(ModelClass.RECEIVER_IMAGE,R.drawable.coffee));
        chatList.add(new ModelClass(ModelClass.SENDER_MESSAGE,"This is a sender message"));
        chatList.add(new ModelClass(ModelClass.RECEIVER_MESSAGE,"This is a receiver message"));
        chatList.add(new ModelClass(ModelClass.SENDER_IMAGE,R.drawable.answer));
        chatList.add(new ModelClass(ModelClass.RECEIVER_IMAGE,R.drawable.coffee));
        chatList.add(new ModelClass(ModelClass.SENDER_MESSAGE,"This is a sender message"));
        chatList.add(new ModelClass(ModelClass.RECEIVER_MESSAGE,"This is a receiver message"));
        chatList.add(new ModelClass(ModelClass.SENDER_IMAGE,R.drawable.answer));
        chatList.add(new ModelClass(ModelClass.RECEIVER_IMAGE,R.drawable.coffee));

        messageAdapter = new MessageAdapter(chatList,MainActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(messageAdapter);
        messageAdapter.notifyDataSetChanged();
    }
}