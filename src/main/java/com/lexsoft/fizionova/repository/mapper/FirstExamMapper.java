package com.lexsoft.fizionova.repository.mapper;

import com.lexsoft.fizionova.repository.model.FirstExam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


@Mapper
public interface FirstExamMapper {

    FirstExam findFirstExam(@Param("firstExamId") Integer firstExamId);

    List<FirstExam> findByParam(@Param("name") String name,
                               @Param("lastname") String lastname,
                               @Param("phoneNumber") String phoneNumber,
                                @Param("idTherapy") Integer idTherapy);

    int insert(@Param("name") String name,
               @Param("lastname") String lastname,
               @Param("phoneNumber") String phoneNumber,
               @Param("examStartTime") String examStartTime,
               @Param("idPatient") Integer idPatient,
               @Param("idTherapy") Integer idTherapy);

    void update(@Param("name") String name,
                @Param("lastname") String lastname,
                @Param("phoneNumber") String phoneNumber,
                @Param("examStartTime") String examStartTime,
                @Param("idPatient") Integer idPatient,
                @Param("firstExamId") Integer firstExamId,
                @Param("idTherapy") Integer idTherapy);

    void deleteFirstExam(@Param("idFirstExam") Integer id);

    void deleteFirstExamByTherapyId(@Param("idTherapy") Integer idTherapy);

    List<FirstExam> findFirstExamsByDate(@Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo);

}
