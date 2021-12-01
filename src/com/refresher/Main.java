package com.refresher;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        boolean game = true;
        ArrayList<Integer> excludeNum = new ArrayList<Integer>();
        ArrayList<Integer> playerPosition = new ArrayList<>();
        ArrayList<Integer> cpuPosition = new ArrayList<>();
        char playerSymbol = 'X';
        char computerSymbol = 'O';

        char[][] gameGrids = {{' ', '|', ' ', '|', ' '},
                               {'-', '+', '-', '+', '-'},
                               {' ', '|', ' ', '|', ' '},
                               {'-', '+', '-', '+', '-'},
                               {' ', '|', ' ', '|', ' '}};

        printGameGrids(gameGrids);

        while(game) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Position: ");
            int pickPosition = scan.nextInt();
            while(playerPosition.contains(pickPosition) || cpuPosition.contains(pickPosition)){
                System.out.println("Invalid!");
                pickPosition = scan.nextInt();
            }
            excludeNum.add(pickPosition);
            playerPosition.add(pickPosition);
            positionMeIn(pickPosition, gameGrids, playerSymbol);
            int genRandom = generateRandom(1, 9, excludeNum);
            System.out.println("computer position: " + genRandom);
            while(playerPosition.contains(cpuPosition) || cpuPosition.contains(cpuPosition)){
                genRandom = generateRandom(1, 9, excludeNum);
                System.out.println("computer position inside while: " + genRandom);
            }
            computer(gameGrids, computerSymbol, genRandom);
            cpuPosition.add(genRandom);


            printGameGrids(gameGrids);
            whoWin(playerPosition, cpuPosition);
        }


    }
    public static void printGameGrids(char [][] gameGrids){
        for(char[] row : gameGrids){
            for(char col : row){
                System.out.print(col);
            }
            System.out.println();
        }
    }
    static void positionMeIn(int _position, char[][] _gameGrids, char _symbol){
        switch (_position){
            case 1:
                _gameGrids[0][0] = _symbol;
                break;
            case 2:
                _gameGrids[0][2] = _symbol;
                break;
            case 3:
                _gameGrids[0][4] = _symbol;
                break;
            case 4:
                _gameGrids[2][0] = _symbol;
                break;
            case 5:
                _gameGrids[2][2] = _symbol;
                break;
            case 6:
                _gameGrids[2][4] = _symbol;
                break;
            case 7:
                _gameGrids[4][0] = _symbol;
                break;
            case 8:
                _gameGrids[4][2] = _symbol;
                break;
            case 9:
                _gameGrids[4][4] = _symbol;
                break;
            default:
                break;
        }
    }
    static void computer(char[][] _gameGrids, char _symbol, int _RANDOMNESS){
        switch (_RANDOMNESS){
            case 1:
                _gameGrids[0][0] = _symbol;
                break;
            case 2:
                _gameGrids[0][2] = _symbol;
                break;
            case 3:
                _gameGrids[0][4] = _symbol;
                break;
            case 4:
                _gameGrids[2][0] = _symbol;
                break;
            case 5:
                _gameGrids[2][2] = _symbol;
                break;
            case 6:
                _gameGrids[2][4] = _symbol;
                break;
            case 7:
                _gameGrids[4][0] = _symbol;
                break;
            case 8:
                _gameGrids[4][2] = _symbol;
                break;
            case 9:
                _gameGrids[4][4] = _symbol;
                break;
            default:
                break;
        }
    }
    static int generateRandom(int start, int end, ArrayList<Integer> _excludeNum) {
        Random rand = new Random();
        int range = end - start + 1;

        int random = rand.nextInt(range) + 1;
        while(_excludeNum.contains(random)) {
            random = rand.nextInt(range) + 1;
        }

        return random;
    }
    static void whoWin(ArrayList<Integer> _playerPosition, ArrayList<Integer> _cpuPosition){

        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List rightCol = Arrays.asList(3, 6, 9);
        List midCol = Arrays.asList(2, 5, 8);
        List leftCol = Arrays.asList(1, 4, 7);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(3, 5, 7);

        ArrayList<List> win = new ArrayList<>();

        win.add(topRow);
        win.add(midRow);
        win.add(botRow);
        win.add(rightCol);
        win.add(midCol);
        win.add(leftCol);
        win.add(cross1);
        win.add(cross2);

        for(List l : win) {
            if (_playerPosition.containsAll(l)){
                System.out.println("Player win!");
            }else if(_cpuPosition.containsAll(l)){
                System.out.println("CPU win!");
            }else if(_cpuPosition.size() + _playerPosition.size() == 9){
                System.out.println("it's a tie!");
            }
        }










    }
}
