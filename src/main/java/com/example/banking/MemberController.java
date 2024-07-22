package com.example.banking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    private final MemberRepository memberRepository;

    MemberController(MemberRepository repository){
        memberRepository = repository;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
        Member member = memberService.getMemberById(id);
        return ResponseEntity.ok(member);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getTotalLoanByName(@PathVariable String name){
        Member member = memberService.getMemberByName(name);
        if (member != null){
            Double amount = memberService.calculateTotalLoan(member);
            return ResponseEntity.ok(amount);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Member not found with name: " + name);
        }
    }

    @PostMapping("/add")
    Member newMember(@RequestBody Member member){
        return memberRepository.save(member);
    }

    @PutMapping("/{id}")
    Member replaceMember(@RequestBody Member newMember, @PathVariable Long id) {

        return memberRepository.findById(id)
                .map(employee -> {
                    employee.setName(newMember.getName());
                    employee.setPhone(newMember.getPhone());
                    return memberRepository.save(employee);
                })
                .orElseGet(() -> {
                    return memberRepository.save(newMember);
                });
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable Long id) {
        if (memberRepository.existsById(id)) {
            memberRepository.deleteById(id);
            return ResponseEntity.ok("Member deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Member not found with ID: " + id);
        }
    }
}