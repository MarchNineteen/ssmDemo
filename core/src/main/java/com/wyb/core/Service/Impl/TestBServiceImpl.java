package com.wyb.core.Service.Impl;

import com.wyb.core.Service.TestService;
import org.springframework.stereotype.Service;

/**
 * Created by 15019 on 2017/3/21.
 */
@Service(value = "b")
public class TestBServiceImpl implements TestService {
    @Override
    public String buildString() {
        return "TestB";
    }
}
