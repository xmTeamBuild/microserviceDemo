package com.eg.api.domain;

import java.io.Serializable;
import java.util.List;

public class PageResult<T> extends Page implements Serializable {

    /**
     * 分页对象.<br>
     * 提供给外部系统的分页Bean<br>
     *
     * @param <T>
     *            结果集的数据类型 Date: 2017年2月22日 <br>
     *            Copyright (c) 2017 asiainfo.com <br>
     * @author gucl
     */
        private static final long serialVersionUID = 1L;
        /**
         * 是否业务成功
         */
        private boolean success;

        /**
         * 结果集
         */
        private List<T> result;

        public PageResult() {

        }

        public PageResult(Page page) {
            super(page);
        }


        public List<T> getResult() {
            return result;
        }

        public void setResult(List<T> result) {
            this.result = result;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

    }
