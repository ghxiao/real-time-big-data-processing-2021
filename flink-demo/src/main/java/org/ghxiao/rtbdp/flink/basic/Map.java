package org.ghxiao.rtbdp.flink.basic;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class Map {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<Integer> integers = env.fromElements(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        SingleOutputStreamOperator<Integer> doubleIntegers = integers.map(t -> t * 2);
        doubleIntegers.print();
        env.execute("Map Example");
    }
}
