package threadPool.util;

import lombok.Data;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author weed
 * @since 2020-07-13
 */
@Data
public class DyMonitorRecord implements Comparable<DyMonitorRecord>, Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 监控类型（0-直播间，1-粉丝列表，2-作品）
     */
    private Integer type;

    /**
     * 房间id
     */
    private String roomId;

    /**
     * 作品id
     */
    private String productId;

    /**
     * 查询总数
     */
    private Long totalCount;

    /**
     * 完成数
     */
    private Long finishCount;

    /**
     * 是否结束
     */
    private Integer end;


    private static final Comparator<DyMonitorRecord> COMPARATOR =
            Comparator
                    .comparingLong((DyMonitorRecord dy) -> dy.totalCount)
                    .thenComparingLong((dy) -> dy.finishCount)
                    .thenComparingInt((dy) -> dy.type);

    @Override
    public int compareTo(DyMonitorRecord o) {
        return COMPARATOR.compare(this, o);
    }
}
