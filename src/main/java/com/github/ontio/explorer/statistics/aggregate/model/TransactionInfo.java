package com.github.ontio.explorer.statistics.aggregate.model;

import com.github.ontio.explorer.statistics.aggregate.support.DateIdUtil;
import com.github.ontio.explorer.statistics.model.TxDetail;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author LiuQi
 */
@Builder
@Getter
@ToString
public class TransactionInfo implements Serializable {

	private static final int EVENT_TYPE_TRANSFER = 3;

	private static final int EVENT_TYPE_GAS = 2;

	private static final BigDecimal ONG_MULTIPLE = new BigDecimal("0.000000001");

	private String txHash;

	private int txTime;

	private int blockHeight;

	private BigDecimal amount;

	private BigDecimal fee;

	private String assetName;

	private String fromAddress;

	private String toAddress;

	private int eventType;

	private String contractHash;

	private String calledContractHash;

	private int dateId;

	public BigDecimal getAmount() {
		return "ong".equalsIgnoreCase(assetName) ? amount.multiply(ONG_MULTIPLE) : amount;
	}

	public boolean isTransfer() {
		return EVENT_TYPE_TRANSFER == eventType;
	}

	public boolean isGas() {
		return EVENT_TYPE_GAS == eventType;
	}

	public boolean isSelfTransaction() {
		return fromAddress.equals(toAddress);
	}

	public static TransactionInfo wrap(TxDetail txDetail) {
		TransactionInfoBuilder builder = new TransactionInfoBuilder()
				.txHash(txDetail.getTxHash())
				.txTime(txDetail.getTxTime())
				.blockHeight(txDetail.getBlockHeight())
				.amount(txDetail.getAmount())
				.fee(txDetail.getFee())
				.assetName(txDetail.getAssetName())
				.fromAddress(txDetail.getFromAddress())
				.toAddress(txDetail.getToAddress())
				.eventType(txDetail.getEventType())
				.contractHash(txDetail.getContractHash())
				.calledContractHash(txDetail.getCalledContractHash())
				.dateId(DateIdUtil.parseDateId(txDetail.getTxTime()));
		return builder.build();
	}

}
