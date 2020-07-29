package com.eg.api.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class QueryStaffRequest implements Serializable {
    private static final long serialVersionUID = -1349628913464417269L;

    private Long StaffId ;
    private String StaffName;

}
