package com.example.demo.shell;

import com.example.demo.config.DemoConfig;
import com.example.demo.config.StaticConfig;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.stream.IntStream;

/**
 * @author yuyee
 * @date 2023/8/15 08:38
 * @description
 */
@ShellComponent
public class ShellFunction {
    @Autowired
    private DemoConfig demoConfig;

    @ShellMethod
    public void run(int count, @ShellOption boolean beanStore, @ShellOption boolean staticStore) {
        System.out.println("此次运行次数：" + count);
        IntStream.rangeClosed(1, count)
                .forEach(i -> {
                    demoConfig.getRunTimes().addAndGet(1);
                    String random = RandomStringUtils.randomAlphabetic(64);
                    if (demoConfig.getStore().contains(random)) {
                        demoConfig.getHitCount().addAndGet(1);
                        return;
                    }
                    if (beanStore) {
                        demoConfig.getStore().add(random);
                    }
                    if (staticStore) {
                        StaticConfig.store.add(random);
                    }
                });
    }

    @ShellMethod
    public void show() {
        System.out.println("总运行次数：" + demoConfig.getRunTimes().get());
        System.out.println("首次命中次数：" + demoConfig.getHitCount().get());
        System.out.println("bean存储集元素个数：" + demoConfig.getStore().size());
        System.out.println("static存储集元素个数：" + StaticConfig.store.size());
    }

    @ShellMethod
    public void clean() {
        System.out.println("清空bean存储集...");
        demoConfig.getStore().clear();
    }
}
