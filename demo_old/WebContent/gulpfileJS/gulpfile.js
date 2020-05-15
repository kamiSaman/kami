var gulp = require('gulp');
var rename = require('gulp-rename');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var jshint = require('gulp-jshint');
var webserver = require('gulp-webserver');
var runSequence = require('run-sequence');
var del = require('del');
var replace = require('gulp-replace');
var stylus = require('gulp-stylus');
var autoprefixer = require('gulp-autoprefixer');
var cssmin = require('gulp-cssmin');
var minimist = require('minimist');
var stripDebug = require('gulp-strip-debug');

// minimistでコマンドライン引数をパース
var args = minimist(process.argv.slice(2));

gulp.task('default', ["watch", "dev"]);

//task watch
gulp.task('watch', function(){

  gulp.watch([
    'dev/src/js/module/*/*.js',
    'dev/src/js/module/*/*/*.js',
    'dev/src/js/module/*/*/*/*.js',
    'dev/src/stylus/*.styl',
    'dev/src/stylus/**/*.styl',
    'dev/src/stylus_sp/*.styl',
    'dev/src/stylus_sp/**/*.styl',
    ]
    , ['dev']);

  gulp.src('./')
    .pipe(webserver({
      livereload: true,
      // directoryListing: true,
      open: true,
      port: 8000,
  }));

});

//task dev
gulp.task('dev', function (cb) {
  runSequence(['dev_concat', 'stylus', 'stylus_sp'], "dev_jshint", cb);
});

//task dev_concat
gulp.task('dev_concat', function () {
  //app002
  gulp.src('dev/src/js/module/app/002/pc/*.js')
    .pipe( concat('app002.js') )
    .pipe(gulp.dest('dev/src/js/app'));

  //app002_sp
  gulp.src('dev/src/js/module/app/002/sp/*.js')
    .pipe( concat('app002_sp.js') )
    .pipe(gulp.dest('dev/src/js/app'));

  //app003.js
  gulp.src([
    'dev/src/js/module/app/003/namespace/*.js',
    'dev/src/js/module/app/003/ctrl/*.js',
    'dev/src/js/module/app/003/model/*.js',
    'dev/src/js/module/app/003/view/*.js',
    ])
    .pipe( concat('app003.js') )
    .pipe(gulp.dest('dev/src/js/app'));

  //app003_sp.js
  gulp.src([
    'dev/src/js/module/app/003/namespace/*.js',
    'dev/src/js/module/app/003/sp_ctrl/*.js',
    'dev/src/js/module/app/003/model/*.js',
   'dev/src/js/module/app/003/sp_view/*.js',
    ])
    .pipe( concat('app003_sp.js') )
    .pipe(gulp.dest('dev/src/js/app'));

  //app004
  gulp.src('dev/src/js/module/app/004/pc/*.js')
    .pipe( concat('app004.js') )
    .pipe(gulp.dest('dev/src/js/app'));

  //app004_sp
  gulp.src('dev/src/js/module/app/004/sp/*.js')
    .pipe( concat('app004_sp.js') )
    .pipe(gulp.dest('dev/src/js/app'));

  //app004_phase2
  gulp.src('dev/src/js/module/app/004_phase2/*.js')
    .pipe( concat('app004_phase2.js') )
    .pipe(gulp.dest('dev/src/js/app'));

  //appsport.js
  gulp.src([
    'dev/src/js/module/app/sport/namespace/*.js',
    'dev/src/js/module/app/sport/ctrl/*.js',
    'dev/src/js/module/app/sport/model/*.js',
    'dev/src/js/module/app/sport/view/*.js',
    ])
    .pipe( concat('appsport.js') )
    .pipe(gulp.dest('dev/src/js/app'));

  //appsport_sp.js
  gulp.src([
    'dev/src/js/module/app/sport/namespace/*.js',
    'dev/src/js/module/app/sport/sp_ctrl/*.js',
    'dev/src/js/module/app/sport/model/*.js',
    'dev/src/js/module/app/sport/sp_view/*.js',
    ])
    .pipe( concat('appsport_sp.js') )
    .pipe(gulp.dest('dev/src/js/app'));

  //etc
  gulp.src('dev/src/js/module/etc/*.js')
    .pipe(gulp.dest('dev/src/js/etc'));

  //config
  gulp.src([
      'dev/src/js/module/etc/config/common.js',
      'dev/src/js/module/etc/config/pc.js',
      'dev/src/js/module/etc/config/end.js'
    ])
    .pipe( concat('config.js') )
    .pipe(gulp.dest('dev/src/js/etc'));

  //utility
  gulp.src([
      'dev/src/js/module/etc/utility/utility.js',
      'dev/src/js/module/etc/utility/analytics.js'
    ])
    .pipe( concat('utility.js') )
    .pipe(gulp.dest('dev/src/js/etc'));

  //sp_config
  gulp.src([
      'dev/src/js/module/etc/config/common.js',
      'dev/src/js/module/etc/config/sp.js',
      'dev/src/js/module/etc/config/end.js'
    ])
    .pipe( concat('sp_config.js') )
    .pipe(gulp.dest('dev/src/js/etc'));

  //appsample
  return gulp.src('dev/src/js/module/app/sample/*.js')
    .pipe( concat('appsample.js') )
    .pipe(gulp.dest('dev/src/js/app'));

});

//task dev_jshint
gulp.task('dev_jshint', function () {
  return gulp.src(['dev/src/js/app/*.js', 'dev/src/js/class/*.js', 'dev/src/js/etc/*.js'])
    .pipe(jshint({sub:true, expr:true}))
    .pipe(jshint.reporter('jshint-stylish'));
});

//task stylus
gulp.task('stylus', function() {
  return gulp.src(['dev/src/stylus/*', 'dev/src/stylus/**/*'])
  .pipe(stylus())
  .pipe(autoprefixer({
  browsers: ['last 3 versions', 'Explorer >= 10', "Android >= 4.0"],
  cascade: false
  }))
  .pipe(gulp.dest('dev/src/css/'));
});
gulp.task('stylus_sp', function() {
  return gulp.src(['dev/src/stylus_sp/*', 'dev/src/stylus_sp/**/*'])
  .pipe(stylus())
  .pipe(autoprefixer({
  browsers: ['last 3 versions', "Android >= 4.0"],
  cascade: false
  }))
  .pipe(gulp.dest('dev/src/css_sp/'));
});

//task clean
gulp.task('clean', function () {
  return del(['release/*']);
});


//task release
gulp.task('release', function (cb) {
  runSequence(
    "release_before_clean",
    "release_copy",
    "release_concat_before_clean",
    ["release_concat","release_replace_path", "css_min"],
    "release_replace_timestamp",
    "release_after_clean",
    "release_backup",
    cb);
});

//task release_before_clean
gulp.task('release_before_clean', function () {
  return del(['release/*']);
});

//task release_copy
gulp.task('release_copy', function () {
  return gulp.src([
      'dev/*',
      'dev/*/*',
      'dev/*/*/*',
      'dev/*/*/*/*',
      'dev/*/*/*/*/*',
      'dev/*/*/*/*/*/*',
      'dev/*/*/*/*/*/*/*'
    ])
    .pipe( gulp.dest( 'release' ) );
});

//task release_concat_before_clean
gulp.task('release_concat_before_clean', function () {
  return del(['release/src/js/app/*']);
});

//task release_concat
gulp.task('release_concat', function () {

  //app002
  gulp.src('release/src/js/module/app/002/pc/*.js')
    .pipe( concat('app002.js') )
    .pipe(stripDebug())
    .pipe(uglify())
    // .pipe(rename({suffix: '.min'}))
    .pipe(gulp.dest('release/src/js/app'));

  //app002_sp
  gulp.src('release/src/js/module/app/002/sp/*.js')
    .pipe( concat('app002_sp.js') )
    .pipe(stripDebug())
    .pipe(uglify())
    // .pipe(rename({suffix: '.min'}))
    .pipe(gulp.dest('release/src/js/app'));

  //app004
  gulp.src('release/src/js/module/app/004/pc/*.js')
    .pipe( concat('app004.js') )
    .pipe(stripDebug())
    .pipe(uglify())
    // .pipe(rename({suffix: '.min'}))
    .pipe(gulp.dest('release/src/js/app'));

  //app004_sp
  gulp.src('release/src/js/module/app/004/sp/*.js')
    .pipe( concat('app004_sp.js') )
    .pipe(stripDebug())
    .pipe(uglify())
    // .pipe(rename({suffix: '.min'}))
    .pipe(gulp.dest('release/src/js/app'));

  //app004_phase2
  gulp.src('release/src/js/module/app/004_phase2/*.js')
    .pipe( concat('app004_phase2.js') )
    .pipe(stripDebug())
    .pipe(uglify())
    // .pipe(rename({suffix: '.min'}))
    .pipe(gulp.dest('release/src/js/app'));


  //etc
  gulp.src('release/src/js/module/etc/*.js')
    .pipe(stripDebug())
    .pipe(uglify())
    // .pipe(rename({suffix: '.min'}))
    .pipe(gulp.dest('release/src/js/etc'));

  //config
  gulp.src([
      'release/src/js/module/etc/config/common.js',
      'release/src/js/module/etc/config/pc.js',
      'release/src/js/module/etc/config/end.js'
    ])
    .pipe( concat('config.js') )
    .pipe(stripDebug())
    .pipe(uglify())
    .pipe(gulp.dest('release/src/js/etc'));

  //sp_config
  gulp.src([
      'release/src/js/module/etc/config/common.js',
      'release/src/js/module/etc/config/sp.js',
      'release/src/js/module/etc/config/end.js'
    ])
    .pipe( concat('sp_config.js') )
    .pipe(stripDebug())
    .pipe(uglify())
    .pipe(gulp.dest('release/src/js/etc'));

  //utility
  gulp.src([
      'release/src/js/module/etc/utility/utility.js',
      'release/src/js/module/etc/utility/analytics.js'
    ])
    .pipe( concat('utility.js') )
    .pipe(stripDebug())
    .pipe(uglify())
    .pipe(gulp.dest('release/src/js/etc'));

  //app003.js
  gulp.src([
    'release/src/js/module/app/003/namespace/*.js',
    'release/src/js/module/app/003/ctrl/*.js',
    'release/src/js/module/app/003/model/*.js',
    'release/src/js/module/app/003/view/*.js',
    ])
    .pipe( concat('app003.js') )
    .pipe(stripDebug())
    .pipe(uglify())
    .pipe(gulp.dest('release/src/js/app'));

  //appsport.js
  gulp.src([
    'release/src/js/module/app/sport/namespace/*.js',
    'release/src/js/module/app/sport/ctrl/*.js',
    'release/src/js/module/app/sport/model/*.js',
    'release/src/js/module/app/sport/view/*.js',
    ])
    .pipe( concat('appsport.js') )
    .pipe(stripDebug())
    .pipe(uglify())
    .pipe(gulp.dest('release/src/js/app'));

  //appsport_sp.js
  gulp.src([
    'release/src/js/module/app/sport/namespace/*.js',
    'release/src/js/module/app/sport/sp_ctrl/*.js',
    'release/src/js/module/app/sport/model/*.js',
    'release/src/js/module/app/sport/sp_view/*.js',
    ])
    .pipe( concat('appsport_sp.js') )
    .pipe(stripDebug())
    .pipe(uglify())
    .pipe(gulp.dest('release/src/js/app'));


  //app003_sp.js
  return gulp.src([
    'release/src/js/module/app/003/namespace/*.js',
    'release/src/js/module/app/003/sp_ctrl/*.js',
    'release/src/js/module/app/003/model/*.js',
    'release/src/js/module/app/003/sp_view/*.js',
    ])
    .pipe( concat('app003_sp.js') )
    .pipe(stripDebug())
    .pipe(uglify())
    .pipe(gulp.dest('release/src/js/app'));

});

//task release_replace_path
gulp.task('release_replace_path', function () {
  return gulp.src(['release/sp/*.htm', 'release/sp/*/*.htm', 'release/sp/*/*/*.htm'])
    .pipe(replace(/="\.\.\//g, '="'))
    .pipe(gulp.dest('release/sp'));
});

//task release_replace_timestamp
gulp.task('release_replace_timestamp', function () {

  var date = new Date();
  var month = ("0"+(date.getMonth()+1)).slice(-2);
  var day = ("0"+date.getDate()).slice(-2);
  var hour = ("0"+date.getHours()).slice(-2);
  var minites = ("0"+date.getMinutes()).slice(-2);

  var timeStamp = month + day + hour + minites;

console.log("v=" + timeStamp);

  gulp.src(['release/src/js/etc/config.js', 'release/src/js/etc/sp_config.js'])
    .pipe(replace(/{GULP_TIMESTAMP}/g, timeStamp))
    .pipe(gulp.dest('release/src/js/etc'));

  return gulp.src(['release/*.htm', 'release/*/*.htm', 'release/*/*/*.htm', 'release/*/*/*/*.htm'])
    .pipe(replace(/<!-- Google Tag Manager/g, '<!-- Google Tag Manager -->'))
    .pipe(replace(/ End Google Tag Manager -->/g, '<!-- End Google Tag Manager -->'))
    .pipe(replace(/{GULP_TIMESTAMP}/g, timeStamp))
    .pipe(gulp.dest('release'));
});



//task release_after_clean
gulp.task('release_after_clean', function (cb) {
  del([
    'release/src/js/module',
    'release/src/js/env/env.js',
    'release/src/js/env/*/env.js',
    'release/src/js/app/appsample.js',
    'release/sample.htm',
    'release/src/stylus',
    'release/src/stylus_sp',
    'release/src/css/module/',
    'release/src/css_sp/module/',
    'release/sample.html'
    ],cb);
});

//task release_backup
gulp.task('release_backup', function () {

  //下記コマンド実行時のみバックアップ生成
  //gulp release --b [バックアップ名(未指定可)]
  //gulp release_backup --b [バックアップ名(未指定可)]
  if (!args.b){
    return;
  }

  var date = new Date();

  var backupDir = date.getFullYear().toString() +
            (date.getMonth() + 1) +
            date.getDate() +
            date.getHours() +
            date.getMinutes() +
            date.getSeconds();

  if (args.b != true) {
    backupDir += "-" + args.b;
  }

  console.log("backupDir:" + backupDir);

  return gulp.src([
      'release/*',
      'release/*/*',
      'release/*/*/*',
      'release/*/*/*/*',
      'release/*/*/*/*/*',
      'release/*/*/*/*/*/*',
      'release/*/*/*/*/*/*/*'
    ])
    .pipe( gulp.dest( 'release_backup/'+backupDir ) );
});

//task css_min
gulp.task('css_min', function () {
  gulp.src('release/src/css/**/*.css')
      .pipe(cssmin())
      .pipe(gulp.dest('release/src/css/'));
});
