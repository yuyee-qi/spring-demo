package com.example.demo.config;

import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author yuyee
 * @date 2023/8/15 08:48
 * @description
 */
@Configuration
public class DemoConfig {
    /**
     * 记录执行的次数
     */
    private AtomicLong runTimes = new AtomicLong(0);
    /**
     * 命中的次数
     */
    private AtomicLong hitCount = new AtomicLong(0);
    /**
     * 用于存储已经出现过的字符串
     */
    private Set<String> store = new HashSet<>();

    public AtomicLong getRunTimes() {
        return runTimes;
    }

    public DemoConfig setRunTimes(AtomicLong runTimes) {
        this.runTimes = runTimes;
        return this;
    }

    public AtomicLong getHitCount() {
        return hitCount;
    }

    public DemoConfig setHitCount(AtomicLong hitCount) {
        this.hitCount = hitCount;
        return this;
    }

    public Set<String> getStore() {
        return store;
    }

    public DemoConfig setStore(Set<String> store) {
        this.store = store;
        return this;
    }

    @Override
    public String toString() {
        return "DemoConfig{" +
                "runTimes=" + runTimes +
                ", hitCount=" + hitCount +
                ", store=" + store +
                '}';
    }
}
