package com.github.ontio.explorer.statistics.mapper;

import com.github.ontio.explorer.statistics.model.NodeOverviewHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface NodeOverviewHistoryMapper extends Mapper<NodeOverviewHistory> {

    List<NodeOverviewHistory> checkHistoryExist();

    int updateRnkEndTime(@Param("roundEndBlock") long roundEndBlock, @Param("roundEndTime") int roundEndTime);

}