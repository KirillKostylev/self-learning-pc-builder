package com.pet.project.pcbuilder.input;

import com.pet.project.pcbuilder.model.dto.GpuRequest;
import com.pet.project.pcbuilder.model.GPU;
import com.pet.project.pcbuilder.output.GpuRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gpus")
@RequiredArgsConstructor
public class GpuController {
    private final GpuRepository gpuRepository;

    @GetMapping
    public List<GPU> getAllGpus() {
        return gpuRepository.findAll();
    }

    @GetMapping("{id}")
    public GPU getById(@PathVariable Long id) {
        return findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public GPU addNewGpu(@RequestBody @Valid GpuRequest gpu) {
        GPU entity = new GPU();
        entity.setName(gpu.name());
        entity.setMemorySize(gpu.memorySize());
        entity.setClockSpeed(gpu.clockSpeed());
        return gpuRepository.save(entity);
    }

    @PutMapping("{id}")
    public GPU updateGpu(
            @PathVariable long id,
            @RequestBody @Valid GpuRequest gpu) {
        var updatedeGpu = findById(id)
                .map(existingGpu -> updateGpuState(existingGpu, gpu))
                .orElseThrow(EntityNotFoundException::new);

        return gpuRepository.save(updatedeGpu);
    }

    private Optional<GPU> findById(long id) {
        return gpuRepository.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        GPU gpu = findById(id).orElseThrow(EntityNotFoundException::new);
        gpuRepository.delete(gpu);
    }

    private GPU updateGpuState(GPU gpu, GpuRequest dto) {
        gpu.setName(dto.name());
        gpu.setClockSpeed(dto.clockSpeed());
        gpu.setMemorySize(dto.memorySize());
        return gpu;
    }
}
