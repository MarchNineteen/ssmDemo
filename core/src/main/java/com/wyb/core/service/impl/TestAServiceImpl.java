package com.wyb.core.service.impl;

import com.wyb.core.service.TestService;
import org.springframework.stereotype.Service;

/**
 *
 * @author 15019
 * @date 2017/3/21
 */
@Service(value = "a")
public class TestAServiceImpl implements TestService {
    @Override
    public String buildString() {
        return "TestA";
    }
}
