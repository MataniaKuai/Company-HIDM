package com.hidm.booksharingscore.vo;

import com.hidm.booksharingscore.entity.Course;

public class CourseSearchVo {
    private Course course;

    private PaginationVo page;
    
    private TimeRangeVo timeRange;
    
    private int[] statusArray;
    
    public int[] getStatusArray() {
        return statusArray;
    }

    public void setStatusArray(int[] statusArray) {
        this.statusArray = statusArray;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public PaginationVo getPage() {
        return page;
    }

    public void setPage(PaginationVo page) {
        this.page = page;
    }

    public TimeRangeVo getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(TimeRangeVo timeRange) {
        this.timeRange = timeRange;
    }
}
