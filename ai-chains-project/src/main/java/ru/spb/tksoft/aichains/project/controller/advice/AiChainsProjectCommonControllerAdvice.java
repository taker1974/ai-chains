package ru.spb.tksoft.aichains.project.controller.advice;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import ru.spb.tksoft.common.controller.advice.CommonControllerAdvice;

/**
 * Interception of very common exceptions. ORDER IS IMPORTANT! @see @Order()
 * 
 * @see ru.spb.tksoft.common.controller.advice.CommonControllerAdvice
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
@ControllerAdvice
@Order()
public class AiChainsProjectCommonControllerAdvice extends CommonControllerAdvice {

    /**
     * Default constructor.
     */
    public AiChainsProjectCommonControllerAdvice() {
        super();
    }
}
