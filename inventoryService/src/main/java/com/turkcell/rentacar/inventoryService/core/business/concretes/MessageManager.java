package com.turkcell.rentacar.inventoryService.core.business.concretes;

import com.turkcell.rentacar.inventoryService.core.business.abstracts.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageManager implements MessageService {
    private MessageSource messageSource;//messages properties message sourece

    @Override
    public String getMessage(String key) {
        return messageSource.getMessage(key,null, LocaleContextHolder.getLocale());
    }

    @Override
    public String getMessageWithArgs(String key, Object... args) {
        return messageSource.getMessage(key,args,LocaleContextHolder.getLocale());
    }
}