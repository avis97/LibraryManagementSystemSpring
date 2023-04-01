package com.SpringJpaFirst.Library_Management_System.DTO;

import com.SpringJpaFirst.Library_Management_System.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IssueBookResponseDto{
    private String transactionNumber;
    private String bookName;
    private int cardId;
    private Date tansactionDate;
    private TransactionStatus transactionStatus;
}
