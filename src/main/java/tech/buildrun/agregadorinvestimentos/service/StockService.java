package tech.buildrun.agregadorinvestimentos.service;

import org.springframework.stereotype.Service;
import tech.buildrun.agregadorinvestimentos.controller.dto.CreateStockDto;
import tech.buildrun.agregadorinvestimentos.controller.dto.StockResponseDto;
import tech.buildrun.agregadorinvestimentos.entity.Stock;
import tech.buildrun.agregadorinvestimentos.repository.StockRepository;

import java.util.List;

@Service
public class StockService {

    private StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }


    public void createStock(CreateStockDto createStockDto) {

        var stock = new Stock(
                createStockDto.stockId(),
                createStockDto.description()
        );

        stockRepository.save(stock);
    }

    public List<StockResponseDto> listAllStocks() {

        return stockRepository.findAll()
                .stream()
                .map(stock -> new StockResponseDto(stock.getStockId(), stock.getDescription()))
                .toList();

    }
}