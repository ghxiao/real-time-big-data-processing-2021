package org.ghxiao.rtbdp.flink.basic;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class FlatMap {
    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env =
                StreamExecutionEnvironment.getExecutionEnvironment(); // configure event time
        DataStream<Integer> integers = env.fromElements(1, 2, 3, 4);
        // Regular Map - Takes one element and produces one element
        DataStream<Integer> doubleIntegers =
                integers.flatMap(new FlatMapFunction<Integer, Integer>() {
                    @Override
                    public void flatMap(Integer value, Collector<Integer> out) throws Exception {
                        out.collect(value * 2);
                        out.collect(value * 3);
                    }
                });
        //.returns(new TypeHint<Integer>() {});
        doubleIntegers.print();
        env.execute("FlatMap Example");

    }
}