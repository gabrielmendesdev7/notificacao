package com.javanauta.notificacao.business.dto;

import com.javanauta.notificacao.business.enums.StatusNotificacaoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatusTarefaPayload {

    private String id;
    private StatusNotificacaoEnum statusNotificacaoEnum;

}
