package org.ghxiao.rtbdp.flink.basic;

import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.ArrayList;
import java.util.List;

public class Reduce {
    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env =
                StreamExecutionEnvironment.getExecutionEnvironment();

        List<Tuple2<String, Integer>> data = new ArrayList<Tuple2<String, Integer>>();
        data.add(new Tuple2<>("odd", 1));
        data.add(new Tuple2<>("even", 2));
        data.add(new Tuple2<>("odd", 3));
        data.add(new Tuple2<>("even", 4));
        DataStream<Tuple2<String, Integer>> tuples = env.fromCollection(data);
        KeyedStream<Tuple2<String, Integer>, Tuple> odd_and_evens = tuples.keyBy(0);

        DataStream<Tuple2<String, Integer>> sums =
                odd_and_evens.reduce(new ReduceFunction<Tuple2<String, Integer>>() {
                    @Override
                    public Tuple2<String, Integer> reduce(
                            Tuple2<String, Integer> t1,
                            Tuple2<String, Integer> t2) throws Exception {
                        return new Tuple2<>(t1.f0, t1.f1 + t2.f1);
                    }
                });
        sums.print();
        env.execute();
    }
}