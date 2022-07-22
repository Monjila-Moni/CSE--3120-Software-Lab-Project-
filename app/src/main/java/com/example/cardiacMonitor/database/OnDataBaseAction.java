package com.example.cardiacMonitor.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.cardiacMonitor.model.Task;

import java.util.List;


@Dao
public interface OnDataBaseAction {

  @Query("SELECT * FROM Task")
  List<Task> getAllTasksList();

  /*  @Query("DELETE FROM Task")
    void truncateTheList();
*/
    @Insert
    void insertDataIntoTaskList(Task task);

    @Query("DELETE FROM Task WHERE taskId = :taskId")
    void deleteTaskFromId(int taskId);

    @Query("SELECT * FROM Task WHERE taskId = :taskId")
    Task selectDataFromAnId(int taskId);

    @Query("UPDATE Task SET date = :date, time = :time, systolic_pressure = :systolic_pressure, diastolic_pressure = :diastolic_pressure, heart_rate = :heart_rate, comment = :comment WHERE taskId = :taskId")
    void updateAnExistingRow(int taskId, String date, String time, String systolic_pressure, String diastolic_pressure,
                             String heart_rate, String comment);

}
