package com.example.banking;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private LoanRepository loanRepository;

    public Member getMemberById(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        return member.orElseThrow(() -> new EntityNotFoundException("Member not found with id: " + id));
    }

    public Member getMemberByName(String name) {
        List<Member> memberList = memberRepository.findByName(name);
        if(memberList.isEmpty()){
            return null;
        }else{
            return memberList.get(0);
        }
    }

    public Double calculateTotalLoan(Member memberToQuery){
        List<Loan> loanList = loanRepository.findByMemberName(memberToQuery.getName());
        Double totalAmount = loanList.stream()
                .mapToDouble(loan -> loan.getPrincipalAmount() * (1 + loan.getInterestRate()))
                .sum();
        return totalAmount;
    }
}
