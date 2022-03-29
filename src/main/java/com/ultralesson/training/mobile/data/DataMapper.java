package com.ultralesson.training.mobile.data;

public interface DataMapper {

    /**
     * A mapping function to map a data to object based on a key.
     * @return T
     */
    default <T> T map(String filename, String key, Class<T> tClass){ throw new UnsupportedOperationException(); }


    /**
     * A mapping function to map a data to object.
     * @return T
     */
    default <T> T map(String filename, Class<T> tClass){throw new UnsupportedOperationException(); }

    /**
     * A mapping function to map a data to a predecided object.
     * @return T
     */
    default <T> T map(String filename){throw new UnsupportedOperationException(); }
}
