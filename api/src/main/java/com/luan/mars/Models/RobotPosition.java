package com.luan.mars.Models;


public class RobotPosition {

    private int x;
    private int y;
    private Orientation  orientation;

    public RobotPosition() 
    {
        x = 0;
        y = 0;
        orientation = Orientation.NORTH;
    }

    public RobotPosition(int x, int y, Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }
    
   
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Orientation getOrientation()
    {
        return orientation;
    }

    
    
    
    public boolean Move()
    {
        switch (orientation)
        {
            case NORTH:
                y++;
                if(y > 5)
                    return false;
                break;
            case EAST:
                x++;
                if(x > 5)
                    return false;
                break;
            case SOUTH:
                y--;
                if(y < 0)
                    return false;
                break;
            case WEST:
                x--;
                if(x < 0)
                    return false;
                break;
        }
        
        return true;
    }
    
       public void Rotate(char direction)
    {
        if(direction == 'L')
        {
                switch (orientation)
            {
                case NORTH:
                    orientation = Orientation.WEST;
                    break;
                case EAST:
                    orientation = Orientation.NORTH;
                    break;
                case SOUTH:
                    orientation = Orientation.EAST;
                    break;
                case WEST:
                    orientation = Orientation.SOUTH;
                    break;
            }
        }
        
        else if(direction == 'R')
        {
            switch (orientation)
            {
                case NORTH:
                    orientation = Orientation.EAST;
                    break;
                case EAST:
                    orientation = Orientation.SOUTH;
                    break;
                case SOUTH:
                    orientation = Orientation.WEST;
                    break;
                case WEST:
                    orientation = Orientation.NORTH;
                    break;
            }
        }
            
        
    }
    
    
    public void Reset()
    {
         x = 0;
        y = 0;
        orientation = Orientation.NORTH;
    }

    
    @Override
    public String toString()
    {
        return "(" + x + ", " + y + ", " + orientation.toString().charAt(0) + ")";
    }
    

    
}
