// lazyload config

angular.module('app')
    /**
   * jQuery plugin config use ui-jq directive , config the js and css files that required
   * key: function name of the jQuery plugin
   * value: array of the css js file located
   */
  .constant('JQ_CONFIG', {
      easyPieChart:   [   static_resources_url_vendor + '/jquery/jquery.easy-pie-chart/dist/jquery.easypiechart.fill.js'],
      sparkline:      [   static_resources_url_vendor + '/jquery/jquery.sparkline/dist/jquery.sparkline.retina.js'],
      plot:           [   static_resources_url_vendor + '/jquery/flot/jquery.flot.js',
                          static_resources_url_vendor + '/jquery/flot/jquery.flot.pie.js', 
                          static_resources_url_vendor + '/jquery/flot/jquery.flot.resize.js',
                          static_resources_url_vendor + '/jquery/flot.tooltip/js/jquery.flot.tooltip.min.js',
                          static_resources_url_vendor + '/jquery/flot.orderbars/js/jquery.flot.orderBars.js',
                          static_resources_url_vendor + '/jquery/flot-spline/js/jquery.flot.spline.min.js'],
      moment:         [   static_resources_url_vendor + '/jquery/moment/moment.js'],
      screenfull:     [   static_resources_url_vendor + '/jquery/screenfull/dist/screenfull.min.js'],
      slimScroll:     [   static_resources_url_vendor + '/jquery/slimscroll/jquery.slimscroll.min.js'],
      sortable:       [   static_resources_url_vendor + '/jquery/html5sortable/jquery.sortable.js'],
      nestable:       [   static_resources_url_vendor + '/jquery/nestable/jquery.nestable.js',
                          static_resources_url_vendor + '/jquery/nestable/jquery.nestable.css'],
      filestyle:      [   static_resources_url_vendor + '/jquery/bootstrap-filestyle/src/bootstrap-filestyle.js'],
      slider:         [   static_resources_url_vendor + '/jquery/bootstrap-slider/bootstrap-slider.js',
                          static_resources_url_vendor + '/jquery/bootstrap-slider/bootstrap-slider.css'],
      chosen:         [   static_resources_url_vendor + '/jquery/chosen/chosen.jquery.min.js',
                          static_resources_url_vendor + '/jquery/chosen/bootstrap-chosen.css'],
      TouchSpin:      [   static_resources_url_vendor + '/jquery/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.js',
                          static_resources_url_vendor + '/jquery/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.css'],
      wysiwyg:        [   static_resources_url_vendor + '/jquery/bootstrap-wysiwyg/bootstrap-wysiwyg.js',
                          static_resources_url_vendor + '/jquery/bootstrap-wysiwyg/external/jquery.hotkeys.js'],
      dataTable:      [   static_resources_url_vendor + '/jquery/datatables/media/js/jquery.dataTables.min.js',
                          static_resources_url_vendor + '/jquery/plugins/integration/bootstrap/3/dataTables.bootstrap.js',
                          static_resources_url_vendor + '/jquery/plugins/integration/bootstrap/3/dataTables.bootstrap.css'],
      vectorMap:      [   static_resources_url_vendor + '/jquery/bower-jvectormap/jquery-jvectormap-1.2.2.min.js', 
                          static_resources_url_vendor + '/jquery/bower-jvectormap/jquery-jvectormap-world-mill-en.js',
                          static_resources_url_vendor + '/jquery/bower-jvectormap/jquery-jvectormap-us-aea-en.js',
                          static_resources_url_vendor + '/jquery/bower-jvectormap/jquery-jvectormap.css'],
      footable:       [   static_resources_url_vendor + '/jquery/footable/v3/js/footable.min.js',
                          static_resources_url_vendor + '/jquery/footable/v3/css/footable.bootstrap.min.css'],
      fullcalendar:   [   static_resources_url_vendor + '/jquery/moment/moment.js',
                          static_resources_url_vendor + '/jquery/fullcalendar/dist/fullcalendar.min.js',
                          static_resources_url_vendor + '/jquery/fullcalendar/dist/fullcalendar.css',
                          static_resources_url_vendor + '/jquery/fullcalendar/dist/fullcalendar.theme.css'],
      daterangepicker:[   static_resources_url_vendor + '/jquery/moment/moment.js',
                          static_resources_url_vendor + '/jquery/bootstrap-daterangepicker/daterangepicker.js',
                          static_resources_url_vendor + '/jquery/bootstrap-daterangepicker/daterangepicker-bs3.css'],
      tagsinput:      [   static_resources_url_vendor + '/jquery/bootstrap-tagsinput/dist/bootstrap-tagsinput.js',
                          static_resources_url_vendor + '/jquery/bootstrap-tagsinput/dist/bootstrap-tagsinput.css']
                      
    }
  )
  .constant('MODULE_CONFIG', [
      {
          name: 'ngGrid',
          files: [
              static_resources_url_vendor + '/angular/ng-grid/build/ng-grid.min.js',
              static_resources_url_vendor + '/angular/ng-grid/ng-grid.min.css',
              static_resources_url_vendor + '/angular/ng-grid/ng-grid.bootstrap.css'
          ]
      },
      {
          name: 'ui.grid',
          files: [
              static_resources_url_vendor + '/angular/angular-ui-grid/ui-grid.min.js',
              static_resources_url_vendor + '/angular/angular-ui-grid/ui-grid.min.css',
              static_resources_url_vendor + '/angular/angular-ui-grid/ui-grid.bootstrap.css'
          ]
      },
      {
          name: 'ui.select',
          files: [
              static_resources_url_vendor + '/angular/angular-ui-select/dist/select.min.js',
              static_resources_url_vendor + '/angular/angular-ui-select/dist/select.min.css'
          ]
      },
      {
          name:'angularFileUpload',
          files: [
            static_resources_url_vendor + '/angular/angular-file-upload/angular-file-upload.js'
          ]
      },
      {
          name:'ui.calendar',
          files: [static_resources_url_vendor + '/angular/angular-ui-calendar/src/calendar.js']
      },
      {
          name: 'ngImgCrop',
          files: [
              static_resources_url_vendor + '/angular/ngImgCrop/compile/minified/ng-img-crop.js',
              static_resources_url_vendor + '/angular/ngImgCrop/compile/minified/ng-img-crop.css'
          ]
      },
      {
          name: 'angularBootstrapNavTree',
          files: [
              static_resources_url_vendor + '/angular/angular-bootstrap-nav-tree/dist/abn_tree_directive.js',
              static_resources_url_vendor + '/angular/angular-bootstrap-nav-tree/dist/abn_tree.css'
          ]
      },
      {
          name: 'toaster',
          files: [
              static_resources_url_vendor + '/angular/angularjs-toaster/toaster.js',
              static_resources_url_vendor + '/angular/angularjs-toaster/toaster.css'
          ]
      },
      {
          name: 'textAngular',
          files: [
              static_resources_url_vendor + '/angular/textAngular/dist/textAngular-sanitize.min.js',
              static_resources_url_vendor + '/angular/textAngular/dist/textAngular.min.js'
          ]
      },
      {
          name: 'vr.directives.slider',
          files: [
              static_resources_url_vendor + '/angular/venturocket-angular-slider/build/angular-slider.min.js',
              static_resources_url_vendor + '/angular/venturocket-angular-slider/build/angular-slider.css'
          ]
      },
      {
          name: 'com.2fdevs.videogular',
          files: [
              static_resources_url_vendor + '/angular/videogular/videogular.min.js'
          ]
      },
      {
          name: 'com.2fdevs.videogular.plugins.controls',
          files: [
              static_resources_url_vendor + '/angular/videogular-controls/controls.min.js'
          ]
      },
      {
          name: 'com.2fdevs.videogular.plugins.buffering',
          files: [
              static_resources_url_vendor + '/angular/videogular-buffering/buffering.min.js'
          ]
      },
      {
          name: 'com.2fdevs.videogular.plugins.overlayplay',
          files: [
              static_resources_url_vendor + '/angular/videogular-overlay-play/overlay-play.min.js'
          ]
      },
      {
          name: 'com.2fdevs.videogular.plugins.poster',
          files: [
              static_resources_url_vendor + '/angular/videogular-poster/poster.min.js'
          ]
      },
      {
          name: 'com.2fdevs.videogular.plugins.imaads',
          files: [
              static_resources_url_vendor + '/angular/videogular-ima-ads/ima-ads.min.js'
          ]
      },
      {
          name: 'xeditable',
          files: [
              static_resources_url_vendor + '/angular/angular-xeditable/dist/js/xeditable.min.js',
              static_resources_url_vendor + '/angular/angular-xeditable/dist/css/xeditable.css'
          ]
      },
      {
          name: 'smart-table',
          files: [
              static_resources_url_vendor + '/angular/angular-smart-table/dist/smart-table.min.js'
          ]
      },
      {
          name: 'angular-skycons',
          files: [
              static_resources_url_vendor + '/angular/angular-skycons/angular-skycons.js'
          ]
      }
    ]
  )
  // oclazyload config
  .config(['$ocLazyLoadProvider', 'MODULE_CONFIG', function($ocLazyLoadProvider, MODULE_CONFIG) {
      // We configure ocLazyLoad to use the lib script.js as the async loader
      $ocLazyLoadProvider.config({
          debug:  false,
          events: true,
          modules: MODULE_CONFIG
      });
  }])
;
