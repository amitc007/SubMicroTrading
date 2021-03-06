/*******************************************************************************
 * Copyright (c) 2015 Low Latency Trading Limited  :  Author Richard Rose
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at	http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,  software distributed under the License 
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 *******************************************************************************/
package com.rr.om.model.instrument;

import com.rr.core.lang.ZString;
import com.rr.core.model.Currency;
import com.rr.core.model.Exchange;
import com.rr.core.model.SecurityIDSource;

public interface Instrument extends com.rr.core.model.Instrument {

    // different id's
    public ZString getRic();
    public ZString getSymbol();
    public ZString getIsin();
    public ZString getSedol();
    public ZString getCusip();
    public ZString getExchangeRef();
    public ZString getPrimaryRIC();

    // id lookup for fix
    public ZString getSecurityID( SecurityIDSource idsource );

    // market / segment and sector
    public ZString getMarket();
    public ZString getMarketSegment();
    public ZString getMarketSector();

    // trading currency and settlement currency
    @Override
    public Currency getCurrency();
    public Currency getSettlementCurrency();

    @Override
    public Exchange getExchange();

    public ZString getCountry();

    @Override
    public TickType getTickscale();

    // price tolerance 
    public PriceToleranceLimits getPriceToleranceLimits();

    // order must be multiple of lot size (for some exchanges)
    public long getLotSize();

    // boolean getters
    public boolean isPrimaryInstrument();
    public boolean isRestrictedStock();
}
