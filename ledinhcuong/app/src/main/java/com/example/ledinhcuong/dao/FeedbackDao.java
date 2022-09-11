package com.example.ledinhcuong.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ledinhcuong.entity.FeedbackEntity;

import java.util.List;

@Dao
public interface FeedbackDao {

    @Insert
    void insertFeedback(FeedbackEntity feedbackEntity);

    @Query("SELECT * FROM feedback")
    List<FeedbackEntity> getAllFeedback();
}
