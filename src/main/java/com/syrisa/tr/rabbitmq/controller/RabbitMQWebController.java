package com.syrisa.tr.rabbitmq.controller;


import com.syrisa.tr.rabbitmq.model.Employee;
import com.syrisa.tr.rabbitmq.model.MessageInfo;
import com.syrisa.tr.rabbitmq.service.RabbitMQSender;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/javainuse-rabbitmq")
@RequiredArgsConstructor
public class RabbitMQWebController {


    private final RabbitMQSender rabbitMQSender;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("empName") String empName,@RequestParam("empId") String empId) {

        Employee emp=new Employee();
        emp.setEmpId(empId);
        emp.setEmpName(empName);
        rabbitMQSender.send(emp);

        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }
    @PostMapping(value = "/producer/message")
    public String producerMessage(@RequestBody MessageInfo messageInfo) {
        rabbitMQSender.sendMessage(messageInfo);
        return "Message sent to the RabbitMQ Successfully";
    }

}
