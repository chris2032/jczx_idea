package com.jczx.service.impl;

import com.jczx.mappers52.UhMapper;
import com.jczx.model52.Uh;
import com.jczx.service.LoginService;

import java.util.Map;

public class LoginServiceImpl implements LoginService {
    private UhMapper uhMapper;

    public UhMapper getUhMapper() {
        return uhMapper;
    }

    public void setUhMapper(UhMapper uhMapper) {
        this.uhMapper = uhMapper;
    }

    @Override
    public Uh getUhByNameAndPassword(Map map) {
        Uh uh = uhMapper.getUhByNameAndPassword(map);
        return uh;
    }
}
