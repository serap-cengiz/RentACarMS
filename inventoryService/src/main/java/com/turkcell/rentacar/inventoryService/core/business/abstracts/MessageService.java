package com.turkcell.rentacar.inventoryService.core.business.abstracts;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

public interface MessageService {
    String getMessage(String key);
    String getMessageWithArgs(String key,Object... args);

}
