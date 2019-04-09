package com.organOld.outService.wrapper;

import com.organOld.dao.entity.Card;
import com.organOld.outService.constant.TimeConstant;
import com.organOld.outService.contract.CardRequest;
import com.organOld.outService.enumModel.CardStatusEnum;
import com.organOld.outService.model.CardModel;
import com.organOld.outService.tool.Tool;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CardWrapper implements Wrapper<Card,CardModel,CardRequest> {

    @Override
    public CardModel wrap(Card card) {
        CardModel cardModel=new CardModel();
        BeanUtils.copyProperties(card,cardModel);
        cardModel.setTime(Tool.dateToString(card.getTime(), TimeConstant.DATA_FORMAT_YMD));
        cardModel.setStatus(CardStatusEnum.getValue(card.getStatus()));
        cardModel.setIsCreate((card.getIsCreate()==1)?"是":"否");
        return cardModel;
    }

    @Override
    public Card unwrap(CardRequest cardRequest) {
        Card card=new Card();
        BeanUtils.copyProperties(cardRequest,card);
        return card;
    }
}
