package com.lexsoft.fizionova.repository.mapper;

import com.lexsoft.fizionova.repository.model.Heartbeat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface HeartbeatMapper {

    Heartbeat checkHeartbeat(@Param("id") Integer id);
}
