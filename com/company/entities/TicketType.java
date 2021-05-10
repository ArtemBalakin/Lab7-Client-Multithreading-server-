package com.company.entities;

import java.io.Serializable;

/**
 * Возможные типы билетов
 */
public enum TicketType implements Serializable {
    CHEAP,
    BUDGETARY,
    USUAL,
    VIP
}
