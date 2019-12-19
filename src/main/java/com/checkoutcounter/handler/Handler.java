package com.checkoutcounter.handler;

import java.util.List;
/**
 * Created by Sanket Bhsukat on 11/12/2019.
 */
public interface Handler<O,I> {
    O handle(I input);

    O handle(int id);

    List<O> handle();
}
