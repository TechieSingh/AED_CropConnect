/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package FMCG;

import java.time.LocalDate;

/**
 *
 * @author amitanveri
 */
public class Season {

    private final String name;
    private final LocalDate startCommitmentPhase;
    private final LocalDate endCommitmentPhase;
    private final LocalDate startSellingPhase;
    private final LocalDate endSellingPhase;

    public Season(String name, LocalDate startCommitmentPhase, LocalDate endCommitmentPhase, LocalDate startSellingPhase, LocalDate endSellingPhase) {
        this.name = name;
        this.startCommitmentPhase = startCommitmentPhase;
        this.endCommitmentPhase = endCommitmentPhase;
        this.startSellingPhase = startSellingPhase;
        this.endSellingPhase = endSellingPhase;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartCommitmentPhase() {
        return startCommitmentPhase;
    }

    public LocalDate getEndCommitmentPhase() {
        return endCommitmentPhase;
    }

    public LocalDate getStartSellingPhase() {
        return startSellingPhase;
    }

    public LocalDate getEndSellingPhase() {
        return endSellingPhase;
    }

    public boolean isInCommitmentPhase(LocalDate date) {
        return !date.isBefore(startCommitmentPhase) && !date.isAfter(endCommitmentPhase);
    }

    public boolean isInSellingPhase(LocalDate date) {
        return !date.isBefore(startSellingPhase) && !date.isAfter(endSellingPhase);
    }

    public boolean isInSeason(LocalDate date) {
        return isInCommitmentPhase(date) || isInSellingPhase(date);
    }
}
