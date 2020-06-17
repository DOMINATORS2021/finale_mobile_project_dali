/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.models.SeriesSelection;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.geom.Shape;
import com.codename1.uikit.materialscreens.SideMenuBaseForm;
import com.mycompany.myapp.entities.Produit;

import java.util.ArrayList;

/**
 *
 * @author bhk
 */
public class BudgetPieChart extends AbstractDemoChart{

    
    
    /**
   * Returns the chart name.
   * 
   * @return the chart name
   */
  @Override
  public String getName() {
    return "Budget chart";
  }

  /**
   * Returns the chart description.
   * 
   * @return the chart description
   */
  public String getDesc() {
    return "The budget per project for this year (pie chart)";
  }

  /**
   * Executes the chart demo.
   * 
   * @return the built intent
   */
  ArrayList<Produit> list;
  @Override
  public Form execute() {
    int[] colors = new int[] { ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW, ColorUtil.CYAN ,ColorUtil.LTGRAY ,ColorUtil.MAGENTA,ColorUtil.BLUE,ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW,ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW };
    final DefaultRenderer renderer = buildCategoryRenderer(colors);
    renderer.setZoomButtonsVisible(true);
    renderer.setZoomEnabled(true);
    renderer.setChartTitleTextFont(largeFont);
    renderer.setDisplayValues(true);
    renderer.setShowLabels(true);
  
    final CategorySeries seriesSet = buildCategoryDataset("Project budget");
    final PieChart chart = new PieChart(seriesSet, renderer);
    
                  
    ChartComponent comp = new ChartComponent(chart){
       
       
         
        private boolean inDrag = false;
        
        @Override
        public void pointerPressed(int x, int y) {
            inDrag = false;
            super.pointerPressed(x, y); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void pointerDragged(int x, int y) {
            inDrag = true;
            super.pointerDragged(x, y); //To change body of generated methods, choose Tools | Templates.
        }

        
        
      protected void seriesReleased(SeriesSelection sel) {
            
            if ( inDrag ){
                // Don't do this if it was a drag operation
                return;
            }
            
            for ( SimpleSeriesRenderer r : renderer.getSeriesRenderers()){
                r.setHighlighted(false);
            }
            SimpleSeriesRenderer r = renderer.getSeriesRendererAt(sel.getPointIndex());
            r.setHighlighted(true);
            
            Shape seg = chart.getSegmentShape(sel.getPointIndex());
            Rectangle bounds = seg.getBounds();
            bounds = new Rectangle(
                    bounds.getX()-40,
                    bounds.getY()-40,
                    bounds.getWidth()+80,
                    bounds.getHeight()+80
            );
            
            this.zoomToShapeInChartCoords(bounds, 500);
        }
    };
    comp.setZoomEnabled(true);
    comp.setPanEnabled(true);
    
    return wrap("Produit Par Quantite", comp);
  }


}

