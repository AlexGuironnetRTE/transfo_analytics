/* Copyright (c) 2020, RTE (http://www.rte-france.com)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.transfo_analytics.operatorfabric;

import org.lfenergy.operatorfabric.cards.model.*;
import org.transfo_analytics.model.EventTempCardData;
import org.transfo_analytics.model.EventTempDeviation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;

@Service
public class CardPublisher {

    public Card createEventTempDevCard(EventTempCardData eventTempCardData) {

        Card card = new Card();

        String process = "event_temp_dev";

        card.setProcess(process);
        card.setProcessId(process+"_"+eventTempCardData.getEventTempDeviationMessage().getTransformer_name()+"_"+eventTempCardData.getEventTempDeviationMessage().getTime());
        card.setPublisher("TRANSFORMERS");
        card.setPublisherVersion("1");

        card.addTagsItem(eventTempCardData.getEventTempDeviationMessage().getTransformer_name());

        Instant eventTimeStamp = Instant.ofEpochMilli(eventTempCardData.getEventTempDeviationMessage().getTime());

        card.setLttd(eventTempCardData.getEventTempDeviationMessage().getTime()*1000);
        card.setStartDate(eventTempCardData.getEventTempDeviationMessage().getTime()*1000);
        card.setEndDate(eventTempCardData.getEventTempDeviationMessage().getTime()*1000+ 2*60*60*1000); //TODO Do something clever with dates

        //TODO Fix timestamp for timeline


        //Test on flag
        System.out.println("Flag for received card was: "+eventTempCardData.getEventTempDeviationMessage().getFlag());
        if(eventTempCardData.getEventTempDeviationMessage().getFlag().matches("failed")) {
            card.setSeverity(SeverityEnum.ALARM);
            card.setState("dev");
        } else if(eventTempCardData.getEventTempDeviationMessage().getFlag().matches("good")) {
            card.setSeverity(SeverityEnum.QUESTION);
            card.setState("no_dev");
        } else {
            card.setSeverity(SeverityEnum.ACTION);
            card.setState("dev"); //TODO undecided status
        }

        Recipient adminUser = new Recipient();
        adminUser.setType(RecipientEnum.USER);
        adminUser.setIdentity("admin");
        card.setRecipient(adminUser);

        I18n i18nTitle = new I18n();
        i18nTitle.setKey(process+".title");
        HashMap<String,String> i18nTitleParams = new HashMap<>();
        i18nTitleParams.put("value",eventTempCardData.getEventTempDeviationMessage().getTransformer_name());
        i18nTitle.setParameters(i18nTitleParams);
        card.setTitle(i18nTitle);

        I18n i18nSummary = new I18n();
        i18nSummary.setKey(process+".summary");
        HashMap<String,String> i18nSummaryParams = new HashMap<>();
        i18nSummaryParams.put("value",eventTempCardData.getEventTempDeviationMessage().getTransformer_name());
        i18nSummary.setParameters(i18nSummaryParams);
        card.setSummary(i18nSummary);



        card.setData(eventTempCardData);

        return card;
    }

    public CardCreationReport publishCard(Card card) {

        String uri = "http://localhost:2102/cards";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        /*
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");*/

        HttpEntity<Card> request = new HttpEntity<>(card, headers);

        RestTemplate restTemplate = new RestTemplate();
        CardCreationReport result = restTemplate.postForObject(uri, request, CardCreationReport.class);

        return result;

    }

}
