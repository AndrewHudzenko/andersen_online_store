package com.andersen.onlinestore.service.scheduler;

import com.andersen.onlinestore.dto.response.ClientResponseDto;
import com.andersen.onlinestore.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchedulerService {
    private final ClientService clientService;
    /**
     * // Run on the 28st day of each month
     */
    @Scheduled(cron = "0 0 0 28 * ?")
    public void executeMonthlyJob() {
        List<ClientResponseDto> clients = clientService.getAll();
        for (ClientResponseDto client: clients) {
            if (client.discount()) {

            }
        }



    }
}
